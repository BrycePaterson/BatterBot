import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


class tweet{
	public static void main(String[] args){
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("n3XavRH3oklzkew1WRGBA")
		  .setOAuthConsumerSecret("4k9G5yADbd6XpbBGSbvwPLiXHF0WSUCJuS1JAdhT73Y")
		  .setOAuthAccessToken("476590575-m7DC9YMPpWZIt5JLcHmt5D1JzOopDxp8jHmNxUkA")
		  .setOAuthAccessTokenSecret("suljM1UP8NPUlbUNyGIOAivd6baTNzapuJDDqYzOfYRLf");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
	    try {
			ResponseList<Status> list = twitter.getUserTimeline("TheBatman");
			for (Status status : list) {
		        System.out.println(status.getUser().getName() + ":" +
		                           status.getText());
		    }
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}