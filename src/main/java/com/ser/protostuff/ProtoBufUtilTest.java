package com.ser.protostuff;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhubo
 * Date: 2018-03-27
 * Time: 10:20
 */
public class ProtoBufUtilTest {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("lance");
        student.setAge(28);
        student.setStudentNo("2011070122");
        student.setSchoolName("BJUT");

        byte[] serializerResult = ProtoBufUtil.serializer(student);
        student.hashCode();
        byte[] serializerResult2 = ProtoBufUtil.serializer(student);

        System.out.println("serializer result:" + Arrays.toString(serializerResult));
        System.out.println("serializer result:" + Arrays.toString(serializerResult2));



       /* String str = new String("aaa");

        byte[] serializerResult3 = ProtoBufUtil.serializer(str);
        str.hashCode();
        byte[] serializerResult4 = ProtoBufUtil.serializer(str);
        System.out.println("serializer result:" + Arrays.toString(serializerResult3));
        System.out.println("serializer result:" + Arrays.toString(serializerResult4));*/




        Student deSerializerResult = ProtoBufUtil.deserializer(serializerResult,Student.class);

        System.out.println(deSerializerResult);

    }
}
