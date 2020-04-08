package com.redhat.quarkushackfest.team1.resource;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.chat.v1.HangoutsChat;
import com.google.api.services.chat.v1.model.Message;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import com.redhat.quarkushackfest.team1.model.ChatPayload;
import com.redhat.quarkushackfest.team1.util.JWTVerify;

@Path("/chatbot")
@Produces("application/json")
@Consumes("application/json")
public class ChatBotResource {
	
	static final String CHAT_SCOPE = "https://www.googleapis.com/auth/chat.bot";

    @GET
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello(ChatPayload payload, @HeaderParam("Authorization") String authorization) throws GeneralSecurityException, IOException {
    	
    	System.out.println(payload);
    	
    	if(!JWTVerify.verify(authorization)) {
    		return Response.status(Response.Status.UNAUTHORIZED).build();
    	}
    	
        
       
        assyncReply(payload);

    	
        return Response.status(Response.Status.OK).build();
    }

	private void assyncReply(ChatPayload payload) throws IOException, GeneralSecurityException {
		
		String spaceName = payload.getSpace().getName();
		
		Message reply = new Message();
        
        reply.setText("Hi, I'm Awesome Chat Bot, from Quarkus Hackfest ASSYNC");
    	
    	
        // If replying to a message, set thread name to keep conversation together
        if (payload.getMessage() != null) {
            String threadName = payload.getMessage().getThread().getName();
            com.google.api.services.chat.v1.model.Thread thread = new com.google.api.services.chat.v1.model.Thread();
            thread.setName(threadName);
            reply.setThread(thread);
        }

        GoogleCredentials credentials = GoogleCredentials.fromStream(ChatBotResource.class.getResourceAsStream("/owner4-awesomechatbot-273516-e8bc26a049fa.json"))
        		.createScoped(CHAT_SCOPE);
        
        HttpRequestInitializer requestInitializer = new HttpCredentialsAdapter(credentials);
        HangoutsChat chatService = new HangoutsChat.Builder(
                    GoogleNetHttpTransport.newTrustedTransport(),
                    JacksonFactory.getDefaultInstance(),
                    requestInitializer)
                .setApplicationName("AwesomeChatBot")
                .build();
        chatService.spaces().messages().create(spaceName, reply).execute();
	}
}