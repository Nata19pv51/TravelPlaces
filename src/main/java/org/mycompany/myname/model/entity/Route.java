package org.mycompany.myname.model.entity;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Route {
    private int idRoute;
    private String name;
    private Date dateCreation;
    private User user;

    public int getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(int idRoute) {
        this.idRoute = idRoute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public User getUser() throws Exception {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Route{" +
                "idRoute=" + idRoute +
                ", name='" + name + '\'' +
                ", dateCriation=" + dateCreation +
                '}';
    }

    public static final class RouteBuilder implements IBuilder<Route>{
        private int idRoute;
        private String name;
        private Date dateCreation;
        private User user;

        public RouteBuilder setIdRoute(int idRoute){
            this.idRoute = idRoute;
            return this;
        }

        public RouteBuilder setName(String name){
            this.name = name;
            return this;
        }

        public RouteBuilder setDateCreation(Date dateCreation){
            this.dateCreation = dateCreation;
            return this;
        }

        public RouteBuilder setUser(User user){
            this.user = user;
            return this;
        }
        @Override
        public Route build() {
            Route route = new Route();
            route.setIdRoute(idRoute);
            route.setName(name);
            route.setDateCreation(dateCreation);
            route.setUser(user);
            return route;
        }
    }

    }
