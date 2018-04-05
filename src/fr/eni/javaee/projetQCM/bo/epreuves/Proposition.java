package fr.eni.javaee.projetQCM.bo.epreuves;

public class Proposition {

		private int id;
		private String enonce;
		private boolean estBonne;
		private boolean cochee = false;
		
		public Proposition() {
			super();
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getEnonce() {
			return enonce;
		}

		public void setEnonce(String enonce) {
			this.enonce = enonce;
		}

		public boolean isEstBonne() {
			return estBonne;
		}

		public void setEstBonne(boolean estBonne) {
			this.estBonne = estBonne;
		}

		public boolean isCochee() {
			return cochee;
		}

		public void setCochee(boolean cochee) {
			this.cochee = cochee;
		}
		
		
		
}
