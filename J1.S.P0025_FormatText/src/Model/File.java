/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author 84945
 */
public class File {
    private String pathin = "input.txt";
    private String pathout = "output.txt";
    private String content;

    public File() {
    }

    public File(String content) {
        this.content = content;
    }

    public String getPathin() {
        return pathin;
    }

    public void setPathin(String pathin) {
        this.pathin = pathin;
    }

    public String getPathout() {
        return pathout;
    }

    public void setPathout(String pathout) {
        this.pathout = pathout;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
