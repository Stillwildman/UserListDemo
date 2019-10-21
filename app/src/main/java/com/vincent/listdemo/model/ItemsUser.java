package com.vincent.listdemo.model;

import java.util.List;

public class ItemsUser {


    /**
     * page : 1
     * per_page : 6
     * total : 12
     * total_pages : 2
     * data : [{"id":1,"email":"george.bluth@reqres.in","first_name":"George","last_name":"Bluth","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg"},{"id":2,"email":"janet.weaver@reqres.in","first_name":"Janet","last_name":"Weaver","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"},{"id":3,"email":"emma.wong@reqres.in","first_name":"Emma","last_name":"Wong","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg"},{"id":4,"email":"eve.holt@reqres.in","first_name":"Eve","last_name":"Holt","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg"},{"id":5,"email":"charles.morris@reqres.in","first_name":"Charles","last_name":"Morris","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/stephenmoon/128.jpg"},{"id":6,"email":"tracey.ramos@reqres.in","first_name":"Tracey","last_name":"Ramos","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/bigmancho/128.jpg"}]
     */

    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<UserInfo> data;

    public int getPage() {
        return page;
    }

    public int getPerPpage() {
        return per_page;
    }

    public int getTotal() {
        return total;
    }

    public int getTotalPages() {
        return total_pages;
    }

    public List<UserInfo> getUserInfoList() {
        return data;
    }

    public static class UserInfo {
        /**
         * id : 1
         * email : george.bluth@reqres.in
         * first_name : George
         * last_name : Bluth
         * avatar : https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg
         */

        private int id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;

        public int getId() {
            return id;
        }

        public String getEmail() {
            return email;
        }

        public String getFirstName() {
            return first_name;
        }

        public String getLastName() {
            return last_name;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getFullName() {
            return first_name + " " + last_name;
        }
    }
}
