package ro.iteahome.travelbackend.dtos;

import ro.iteahome.travelbackend.entity.Role;

//@Data
//@Builder

public class ClientDTO {

    private int id;
    private String name;
    private String password;
    private Role role;
    private int status;

    public ClientDTO() {
    }

    public ClientDTO(int id, String name, String password, Role role, int status) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
