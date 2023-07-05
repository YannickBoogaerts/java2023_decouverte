package be.technifutur.decouverte.designPattern.superCanard.abstractfactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class AbstractCanardFactory implements CanardFactory{

    static CanardFactory getfactory(String className){
        try {
            Class<CanardFactory> maClass = (Class<CanardFactory>) Class.forName(className);
            Constructor<CanardFactory> constructor = maClass.getConstructor();
            CanardFactory factory = constructor.newInstance();
            return factory;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
