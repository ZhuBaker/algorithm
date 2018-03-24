package com.jvm.separator;

/**
 * Created with IntelliJ IDEA.
 * Description: 设置为当前上下文默认类加载器 ， 保证顺序加载
 * User: zhubo
 * Date: 2018-03-24
 * Time: 16:13
 */
public class SpringClassLoader extends ClassLoader {

    //策略模式
    private ServiceClassLoader serviceClassLoader;

    public ServiceClassLoader getServiceClassLoader() {
        return serviceClassLoader;
    }

    public void setServiceClassLoader(ServiceClassLoader serviceClassLoader) {
        this.serviceClassLoader = serviceClassLoader;
    }

    /**
     * @param name
     * @return
     */
    private Class<?> loadClasspathClass(String name){
        try{
            return super.loadClass(name);
        }catch (Exception e){
            //下面打印要注释，因为classpath 的ClassLoader处于处于类加载的中间阶段 ,
            // 接下来还有自定义类加载器进行类的加载 如果还没有加载到就抛出异常
            //e.printStackTrace();
        }
        return null;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        try{
            Class<?> clazz = loadClasspathClass(name);
            if(clazz == null){
                clazz = loadThridLibsClass(name);
            }
            if(clazz != null){
                return clazz;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        throw new ClassNotFoundException(name);
    }


    private Class<?> loadThridLibsClass(String name){
        try{
            return serviceClassLoader.loadClass(name);
        }catch (Exception e){
        }
        return null;
    }













}
