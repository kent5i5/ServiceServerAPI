package com.yinkin.yinkinelderservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ProgrammingSkills {

    private int java;
    private int css;
    private int angular;
    private int react;
    private int python;
    private int go;
    public void setJava(int java) {
        this.java = java;
    };
    public void setCss(int css) {
        this.css = css;
    };
    public void setAngular(int angular){
        this.angular= angular;
    };
    public void setReact(int react){
        this.react = react;
    };
    public void setPython(int python){
        this.python = python;
    };
    public void setGo(int go){
        this.go = go;
    };

    public int getJava() {
        return this.java;
    }
    public int getCss() {
        return this.css;
    }
    public int getAngular(){
        return this.angular;
    };
    public int getReact(){
        return this.react;
    };
    public int getPython(){
        return this.python;
    };
    public int getGo(){
        return this.go;
    };
}
