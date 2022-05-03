package com.lange.resources.login;

import com.lange.resources.login.dto.CreatedDTO;
import com.lange.resources.login.dto.LoggedinDTO;
import com.lange.resources.login.dto.LoginDTO;
import com.lange.resources.login.dto.SignUpDTO;
import com.lange.service.AuthService;
import com.lange.service.requests.LoginRequest;
import com.lange.service.requests.SignupRequest;
import com.lange.service.responses.LoginResponse;
import com.lange.service.responses.SignupResponse;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.Date;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/")
public class AuthResource {

    private final AuthService service;
    private final JsonWebToken jwt;


    @Inject
    public AuthResource(AuthService authservice, JsonWebToken jwt) {
        service = authservice;
        this.jwt = jwt;
    }


    @Path("/signup")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)

    public Response Signup(SignUpDTO signUpDTO) {
        SignupRequest request = new SignupRequest(signUpDTO.getEmail(), signUpDTO.getUserName(), signUpDTO.getPassword());

        SignupResponse res = service.signup(request);

        CreatedDTO dto = new CreatedDTO(res.getUser().getUserID().toString());

       return Response.status(Response.Status.CREATED).entity(dto).build();


    }
    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Login(LoginDTO loginDTO) {
        try {
            LoginRequest request = new LoginRequest(loginDTO.getUserName(), loginDTO.getPassword());
            LoginResponse res = service.login(request);

            NewCookie cookie = createCookie(10, res.getToken().getToken());


            return Response.ok().header("Set-Cookie", "" + cookie + "; SameSite=lax").entity(new LoggedinDTO(true, loginDTO.getUserName())).build();
        }
        catch (Exception e)  {

            return Response.ok().entity(e).build();
        }
    }



    @Path("/login")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response checkLoggedIn() {
        // Something about get token check UUID
        // If value is null return signed out else get user
        String jwtString = jwt.getClaim(Claims.preferred_username);

        if (jwtString != null) {
            return  Response.ok().entity( new LoggedinDTO(true, jwtString)).build();
        }
        return Response.ok().entity( new LoggedinDTO(false, null)).build();


    }

@Path("/logout")
@GET
public Response logout() {

        return Response.ok().cookie(createCookie(0, null)).entity(new LoggedinDTO(false, null)).build();

}

    private NewCookie createCookie(int age, String token) {
        if (age > 0) {
            return new NewCookie("jwt", token, "/", "localhost", "comment", age + 3600, false, true);
        }
        return new NewCookie("jwt", null, "/", "localhost", 0, "comment", 0, new Date(0), false, true);
    }




}
