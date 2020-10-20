// this agent is Mafia
// spreads information that leeteuk is Mafia

mafia(.my_name, kyuhyun, yesung).

+story(N)[source(S)] : true <-
.print("I heard from ", S ," that leeteuk is Mafia").

