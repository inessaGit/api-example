package api.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
/*
The above class Student contains the following:

Fields – id, firstName, lastName, gender
Getters – for fetching the field values
Setters – for setting the field values
toString() – for printing the object

e in the Student class, all the fields are annotated with @JsonProperty.
The purpose of having that annotation over the fields is that,
during the process of serialization to JSON or deserialization from JSON,
we need to know what key the fields should be mapped to.
 */
public class User {
    public User() {
        //default empty constructor
    }

    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @JsonProperty("name")
    private String name;
    @JsonProperty("job")
    private String job;



    public String getName() {
        return name;
    }

    public void setFirstName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return String.format("User [name=%s, job=%s]", name, job);
    }

}