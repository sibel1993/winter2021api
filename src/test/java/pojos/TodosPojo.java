package pojos;

/*
POJO: plain old java object
pojo is a java class
to cretae a pojo class,we need to do 5 steps ;
1)create "private" variables
2)create all getter and setter
3)create constructor without parameter
4)create constructor with all parameters
5)create toString()

 */

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class TodosPojo {
    //1)create "private" variables
    private int userId;
    private  String title;
    private  boolean completed;



    //2)create all getter and setter


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    //3)create con
    public TodosPojo(){

    }
   // 4)create constructor with all parameter


    public TodosPojo(int userId, String title, boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;

    }
    //5)create toString

    @Override
    public String toString() {
        return "TodosPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed ;
    }
}
