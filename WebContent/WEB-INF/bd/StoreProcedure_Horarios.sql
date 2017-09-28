DELIMITER $$
CREATE PROCEDURE `ConsultarHorario`()
	BEGIN

		SELECT h.idhorario as idhorario,
		s.nombresede as nombresede,
		a.nombreambiente as nombreambiente,
		concat(h.edadmin," a�o(s) a ",h.edadmax, " a�o(s)") as dirigido,
		h.cantsesion as cantsesion,
		h.horassesion as horassesion,
		h.vacantemin as vacantemin,
		h.vacantemax as vacantemax,
		h.fechainicio as fechainicio,
		h.fechafin as  fechafin,
		h.precio as precio


		from
		horario h inner join ambiente a on h.idambiente=a.idambiente
		 inner join sede s on a.idsede = s.idsede
		;
	END ;;
	
	call ConsultarHorario();
