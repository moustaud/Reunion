<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Brainstorming phase</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">

  	<asset:javascript src="websockets/application.js"/>
        <asset:javascript src="websocets/jquery" />
        <asset:javascript src="spring-websocket" />

        <script defer type="text/javascript">
            $(function() {
                //Create a new SockJS socket - this is what connects to the server
                //(preferably using WebSockets).
                var socket = new SockJS("${createLink(uri: '/stomp')}");
                //Build a Stomp client to send messages over the socket we built.
                var client = Stomp.over(socket);

                //Have SockJS connect to the server.
                client.connect({}, function() {
                    //Subscribe to the 'chat' topic and define a function that is executed
                    //anytime a message is published to that topic by the server or another client.
                    client.subscribe("/topic/brainstorm", function(message) {
                      console.log(message)
                        var chatMsg = JSON.parse(JSON.parse(message.body))
                        var time = '<strong>' + new Date(chatMsg.timestamp).toLocaleTimeString() + '</strong>'                        
			$("#chatDiv").append('<strong>Moustapha said : </strong> '+ chatMsg.message + "<br/> at " + time + "<br/>");


                    });
                });
                
                

                //When the user sends a chat message publish it to the chat topic
                $("#sendButton").click(function() {
                    client.send("/app/brainstorm", {}, JSON.stringify($("#chatMessage").val()));
                });
            });
        </script>
    </head>
    <body>
        <section>
            <h2>Brainstorming</h2>                        
		    <input type="text" id="chatMessage" value="" style="width: 500px; height: 60px;" maxlength="255" /><br/>                          
	            <button id="sendButton">Send</button>
	            <div id="chatDiv"></div>           	         
        </section>
    </body>
</html>
