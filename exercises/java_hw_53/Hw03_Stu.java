/** 填空3 可运行版（交超星用带 package com 的写法，见 Hw03_StuPackage.md） */
public class Hw03_Stu {
    public static final String classid = "001";
    public static String school = "YEU";
    private int age;
    public String id;
    public String name;

    public Hw03_Stu(String ids, String names) {
        id = ids;
        name = names;
    }

    public static String getSchool() {
        return school;
    }

    public static void main(String[] args) {
        System.out.println(Hw03_Stu.getSchool());
        System.out.println(Hw03_Stu.school);
    }
}
