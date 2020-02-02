package com.mohsen.jersyapis;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class CommentResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getComments() {
		return "retreiving all comments";
	}
	
	
}
