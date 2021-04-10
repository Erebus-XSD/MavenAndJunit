package reflectionAndAnnotation.reflection;

import reflectionAndAnnotation.Showable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: maven_1
 * @description:
 * @author: Erebus
 * @create: 2021-03-29 19:18
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("请输入类路径");
            String path=sc.nextLine();
            System.out.println("待加载的类为："+path);

            Class c=Class.forName(path);
            String name=c.getName();
            System.out.println(name);

            Field[] fs=c.getDeclaredFields();
            if(fs!=null && fs.length>0){
                for(Field f:fs){
                    String modifier="";
                    switch (f.getModifiers()){
                        case 1:
                            modifier="public";
                            break;
                        case 2:
                            modifier="private";
                            break;

                    }
                    System.out.println(modifier+"\t"+f.getName());
                }
            }
            Method[] ms=c.getDeclaredMethods();
            if(ms!=null && ms.length>0){
                for(Method m:ms){
                    System.out.println(m.getModifiers()+"\t"+m.getReturnType().toString()+"\t"+m.getName());
                }
            }

            Constructor[] cs=c.getConstructors();
            if(cs!=null && cs.length>0){
                for(Constructor m:cs){
                    System.out.println(m.getModifiers()+"\t"+m.getName());
                }
            }

            Object o=c.newInstance();

            if(o instanceof Showable){
                Showable p=(Showable)o;
                p.show();
            }

            System.out.println("----------------");
            if(ms!=null&&ms.length>0){
                for(Method m:ms){
                    if(m.getName().startsWith("sh")){
                        m.invoke(o);
                    }
                }
            }

            Map<String,String> pMap=new HashMap<String,String>();
            pMap.put("name","张三");
            pMap.put("age",30+"");
            Object oo=setValues(pMap,c);
            System.out.println(oo.toString());
        }
    }

    private static Object setValues(Map<String, String> pMap, Class c) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object o=null;
        o=c.newInstance();
        Method[] ms=c.getDeclaredMethods();
        if(ms!=null && ms.length>0){
            for(Method m:ms){
                if(m.getName().startsWith("set")){
                    String mName=m.getName();
                    String fName=mName.substring(3).toLowerCase();
                    String value= pMap.get(fName);

                    if("Integer".equalsIgnoreCase(m.getParameterTypes()[0].getTypeName()) || "int".equalsIgnoreCase(m.getParameterTypes()[0].getTypeName())){
                        m.invoke(o,Integer.parseInt(value));
                    } else {
                        m.invoke(o,value);
                    }
                }
            }
        }
        return o;
    }


}
