package org.mycompany.myname.model.entity;

public class SharedRoute {
    private User receiver;
    private Route route;

    public User getReceiver() throws Exception {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public Route getRoute() throws Exception {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public static final class SharedRouteBuilder implements IBuilder<SharedRoute>{
        private User receiver;
        private Route route;

        public SharedRouteBuilder setReceiver(User receiver){
            this.receiver = receiver;
            return this;
        }

        public SharedRouteBuilder setNote(Route route){
            this.route = route;
            return this;
        }

        @Override
        public String toString() {
            return "SharedRouteBuilder{" +
                    "receiver=" + receiver +
                    ", route=" + route +
                    '}';
        }

        @Override
        public SharedRoute build() {
            SharedRoute sharedRoute = new SharedRoute();
            sharedRoute.setReceiver(receiver);
            sharedRoute.setRoute(route);
            return sharedRoute;
        }
    }

}
