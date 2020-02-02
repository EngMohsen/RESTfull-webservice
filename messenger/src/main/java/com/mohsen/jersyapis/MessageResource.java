package com.mohsen.jersyapis;

import javax.ws.rs.BeanParam;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.mohsen.jersyapis.models.MessagesFilterBean;

@Path("/messages")
public class MessageResource {

	@GET
	@Produces("text/plain")
	public String getMessages() {

		return "Retrieving all messages";

	}

	@GET
	@Path("/{messageId}")
	@Produces("text/plain")
	public String getMessagesById(@PathParam("messageId") String messageId) {

		return "Get Message details for" + messageId;

	}
	
	@POST
	@Produces("text/plain")
	public String getMessagesByFilter(@BeanParam MessagesFilterBean filterBean) {

		return "filtering Messages by year : " + filterBean.getYear();

	}
	
	
/*	@GET
	@Path("/parameters/{messageId}")
	@Produces("text/plain")
	public String allParametersType(@PathParam("messageId") String messageId,
			@MatrixParam("msgContent") String messageCont,
			@HeaderParam("sessionId") long sessionId,
			@CookieParam("userData") String userdata) {

		return "Get Message details for" + messageId;

	}*/
	
	@GET
	@Path("/context")
	@Produces("text/plain")
	public String getContext(@Context UriInfo uriInfo, @Context HttpHeaders headers) {

		return "the absolute pathe of the service is : " + uriInfo.getAbsolutePath().toString()+" , the header values :"+headers.getRequestHeaders();

	}
	

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {

		String output = "Jersey say : " + msg;

		return Response.status(200).entity(output).build();

	}
	
	@Path("/{messageId}/comments")
	public CommentResource getComment() {
		return new CommentResource();
	}

}
