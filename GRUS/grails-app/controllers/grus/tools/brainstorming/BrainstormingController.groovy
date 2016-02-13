package grus.tools.brainstorming

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import groovy.json.JsonBuilder

class BrainstormingController {

    def index() { }
	
	
	/**
	 * Accepts incoming chat messages sent by browsers and routes them
	 * to the 'chat' topic that all browser clients are subscribed to.
	**/
	@MessageMapping("/brainstorming")
	@SendTo("/topic/brainstorming")
	protected String brainstorming(String chatMsg) {
		/**
		 * Use the awesome Groovy JsonBuilder to convert a dynamically-defined
		 * data structure to JSON.
		**/
		def builder = new JsonBuilder()
		builder {
			message(chatMsg)
			timestamp(new Date().getTime())
		}
		builder.toString()
	}
}
