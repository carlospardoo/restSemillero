package com.clearminds.smo.cdpo.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.clearminds.cdpo.dtos.Estudiante;
import com.clearminds.cdpo.excepciones.BDDException;
import com.clearminds.cdpo.servicios.ServicioEstudiante;

@Path("/estudiantes")
public class RestEstudiantes {

	@Path("/insertar")
	@POST
	@Consumes({ "application/json" })
	public void insertar(Estudiante estudiante) {
		System.out.println(estudiante);
		ServicioEstudiante srvEstudiante = null;
		try {
			if (estudiante != null) {

				srvEstudiante = new ServicioEstudiante();
				srvEstudiante.insertarEstudiante(estudiante);
				System.out.println("Estudiante Ingresado:" + estudiante);
			} else {
				System.out.println("Llega estudiante en null");
			}

		} catch (BDDException e) {
			e.printStackTrace();
		}
	}

	@Path("/actualizar")
	@PUT
	@Produces({"application/json"})
	@Consumes({ "application/json" })
	public Estudiante actualizar(Estudiante estudiante) {

		System.out.println("Actualizando estudiante");
		ServicioEstudiante srvEstudiante = null;
		try {
			if (estudiante != null) {

				srvEstudiante = new ServicioEstudiante();

				srvEstudiante.actualizarEstudiante(estudiante);
				System.out.println("Estudiante Modificado:" + estudiante);
			} else {
				System.out.println("Llega estudiante en null");
			}

		} catch (BDDException e) {
			e.printStackTrace();
		}

		return estudiante;
	}
}
