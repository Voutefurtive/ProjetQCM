package fr.eni.javaee.projetQCM.bo;

public class Proposition {

		private int id;
		private String enonce;
		private boolean estBonne;
		
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
}
