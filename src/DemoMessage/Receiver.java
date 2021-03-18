package DemoMessage;
public class Receiver  {
		private String receivemessage;
		private String receivemessage1;
		public String getReceiveMessage()
		{
			return receivemessage;
		}
		public void setReceiveMessage(String receivemessage)
		{
			this.receivemessage = receivemessage;
		}		
		
		public String getReceiveMessage1()
		{
			return receivemessage1;
		}
		public void setReceiveMessage1(String receivemessage1)
		{
			this.receivemessage1 = receivemessage1;
		}
		
		public Receiver(String receivemessage, String receivemessage1) {
			super(); //direct reference to the parent class
			this.receivemessage = receivemessage;
			this.receivemessage1 = receivemessage1;
			}
}

