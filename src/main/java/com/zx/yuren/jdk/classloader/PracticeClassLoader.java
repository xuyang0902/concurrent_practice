package com.zx.yuren.jdk.classloader;


/**
 * 自定义一个类加载器
 *
 * @author xu.qiang
 * @date 18/11/7
 */
public class PracticeClassLoader extends ClassLoader {

    //"/Users/tbj/usr/local/codes/github/practice/target/classes/com/zx/yuren/cache/TestLimit.class"

    private String classPath;

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {

        //检查是否已经加载
        Class<?> loadedClass = findLoadedClass(name);

        if(loadedClass != null){
            return loadedClass;
        }


        //有父类加载器，委托给父类加载
        ClassLoader parent = getParent();
        if(parent != null){

            try{
                Class<?> aClass = parent.loadClass(name);
                if(aClass != null){
                    return aClass;
                }
            }catch (Exception e){
                //父类没有加载到，交给子类加载
                System.out.println(">> 父类加载器没有加载到，子类自己加载");
            }
        }


        //父类加载不到，自己加载
        return findClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {


        return super.findClass(name);
    }
}
