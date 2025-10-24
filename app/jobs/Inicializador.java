package jobs;

import models.Especialidade;
import models.Medico;
import models.Perfil;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job{
	
	@Override
	public void doJob() throws Exception {
		
		if(Especialidade.count() == 0) {
			Especialidade clinico = new Especialidade("Clinico Geral");
			Especialidade Fisio = new Especialidade("Fisioterapia");
			Especialidade Cardio = new Especialidade("Cardiologia");
			Especialidade nutri = new Especialidade("Nutrição");
		
			
		    clinico.save();
			Fisio.save();
			Cardio.save();
			nutri.save();
			
		}
			
	        // Tenta encontrar o admin
			Medico d = Medico.find("email = ?1", "admin@admin.com").first();
			
	        // Se não existir, cria um novo
			if (d == null) {
				d = new Medico();
				d.email = "admin@admin.com";
				d.nome = "admin";
			}
			
	        // Garante que ele SEJA administrador
			d.perfil = Perfil.ADMINISTRADOR; 
			d.senha = "12345";
			d.save();
	        // --- FIM DA CORREÇÃO ---
		}
	}
	
	
	


