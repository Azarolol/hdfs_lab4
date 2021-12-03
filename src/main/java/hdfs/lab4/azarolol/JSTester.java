package hdfs.lab4.azarolol;

import akka.actor.ActorSystem;
import akka.http.javadsl.Http;

public class JSTester {
    final static String ACTOR_SYSTEM_NAME = "ActorsRoutes";
    public static void main (String[] args) {
        ActorSystem system = ActorSystem.create(ACTOR_SYSTEM_NAME);
        final Http http = Http.get(system);

    }
}