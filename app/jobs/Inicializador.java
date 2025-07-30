package jobs;

import models.Especialidade;
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
	}

}
