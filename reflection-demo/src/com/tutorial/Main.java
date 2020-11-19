package com.tutorial;

import java.lang.reflect.*;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("Mây", 2 );
        Class<?> dogClass = dog.getClass();
//        getConstructorOfClass(dogClass);
//        getPublicMethodsOfObject(dogClass);
//        getClassOfObject(dogClass);
//        getFieldsOfClass(dogClass);

        try {
//            Field cryField = getSpecificPublicFieldOfClass(dogClass, "age");
//            Integer dogAge = (Integer) cryField.get(dog);
//            System.out.println(dogAge);

//            Method getAgeMethod = getSpecificPublicMethodOfClass(dogClass, "getAge");
//            int age = (int) getAgeMethod.invoke(dog);
//            System.out.println("Age = " + age);
//            Method setAgeMethod = getSpecificPublicMethodOfClass(dogClass, "setAge", int.class);
//            setAgeMethod.invoke(dog, 5);
//            System.out.println("New Age = " + dog.getAge());

            getGetterSetterMethod(dogClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getConstructorOfClass(Class aClass) {
        // Lấy ra danh sách các cấu tử của Dog.
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("Constructor: " + constructor.getName());
            Parameter[] parameters = constructor.getParameters();
            if (parameters.length > 0) {
                System.out.println("\tParameters:");
                for (Parameter parameter: parameters) {
                    System.out.println("\t\tName:" + parameter.getName() + ", Type: " + parameter.getType());
                }
            } else {
                System.out.println("\tParameters: No Parameters");
            }
        }
    }

    private static void getPublicMethodsOfClass(Class aClass) {
        // Lấy ra danh sách các method public của class này
        // Bao gồm các các method thừa kế từ class cha, hoặc các interface.
        Method[] methods = aClass.getMethods();
        System.out.println("Method of dog:");
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }

    private static void getClassOfClass(Class aClass) {
        // Ghi ra tên class, bao gồm cả tên package.
        System.out.println("Class Name= " + aClass.getName());

        // Ghi ra tên đơn giản của Class
        System.out.println("Simple Class Name= " + aClass.getSimpleName());

        // Thông tin Package.
        Package pkg = aClass.getPackage();
        System.out.println("Package Name = " + pkg.getName());

        // Modifier
        int modifiers = aClass.getModifiers();

        boolean isPublic = Modifier.isPublic(modifiers);
        boolean isInterface = Modifier.isInterface(modifiers);
        boolean isAbstract = Modifier.isAbstract(modifiers);
        boolean isFinal = Modifier.isFinal(modifiers);

        // true
        System.out.println("Is Public? " + isPublic);
        // true
        System.out.println("Is Final? " + isFinal);
        // false
        System.out.println("Is Interface? " + isInterface);
        // false
        System.out.println("Is Abstract? " + isAbstract);
    }

    private static void getFieldsOfClass(Class aClass) {
        // Lấy ra danh sách các field public
        // Kể các các public field thừa kế từ các class cha, và các interface
        Field[] fields = aClass.getFields();

        System.out.println(" ==== FIELDs:    ====== ");
        for (Field field : fields) {
            System.out.println("Field: " + field.getName());
        }
    }

    private static Field getSpecificPublicFieldOfClass(Class aClass, String fieldName) throws NoSuchFieldException {
        Field field = aClass.getField(fieldName);
        // Ghi ra kiểu của Field
        Class<?> fieldType = field.getType();
        System.out.println("Field type: " + fieldType.getSimpleName());
        return field;
    }

    @SuppressWarnings("unchecked")
    private static Method getSpecificPublicMethodOfClass(Class aClass, String methodName, Class<?> ... parameterTypes) throws NoSuchMethodException {
        // Lấy ra đối tượng 'Method' mô tả method getAge()
        Method method;
        if (parameterTypes.length > 0) {
            method = aClass.getMethod(methodName, parameterTypes);
        } else {
            method = aClass.getMethod(methodName);
        }
        // Kiểu trả về của method getAge
        Class<?> returnType= method.getReturnType();
        System.out.println("Return type of method: " + methodName + " is " + returnType.getSimpleName());
        return method;
    }

    private static void getGetterSetterMethod(Class aClass) {
        // Lấy ra danh sách các public method.
        Method[] methods = aClass.getMethods();

        for (Method method : methods) {
            boolean isSetter = isSetter(method);
            boolean isGetter = isGetter(method);
            System.out.println("Method: " + method.getName());
            System.out.println(" - Is Setter? " + isSetter);
            System.out.println(" - Is Getter? " + isGetter);
        }

    }

    public static boolean isGetter(Method method) {
        if (!method.getName().startsWith("get")) {
            return false;
        }
        if (method.getParameterTypes().length != 0) {
            return false;
        }
        if (void.class.equals(method.getReturnType())) {
            return false;
        }
        return true;
    }


    // Method là setter nếu có tên bắt đầu bằng set, và chỉ có 1 tham số.
    public static boolean isSetter(Method method) {
        if (!method.getName().startsWith("set")) {
            return false;
        }
        if (method.getParameterTypes().length != 1) {
            return false;
        }
        return true;
    }
}
