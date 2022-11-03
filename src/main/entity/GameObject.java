package main.entity;

import main.graphic.CcVector;

import java.lang.reflect.Field;

public class GameObject extends Entity {



    // 通过反射 复制一个对象
    public GameObject cloneObject() {

        try {
            GameObject cloneObj = new GameObject();
            Class<?> sClass = this.getClass();
            for (Field field : sClass.getFields()) {
                field.setAccessible(true);
                field.set(cloneObj, field.get(this));
            }
            cloneObj.pos = new CcVector(this.pos);
            cloneObj.box = new CcVector(this.box);
            cloneObj.img = this.img;
            return cloneObj;

        } catch (Exception e) {
            return null;
        }
    }
}
