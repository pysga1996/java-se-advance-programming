package com.tutorial;

public class Main {
    public static void main(String[] args) {
//        ConsoleDemo.consoleExample1();
//        FilePermissionDemo.addPermission("E:\\region.xml", new String[] {"read","write"});
        String content = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Demo HTML Page</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<span style=\"color: red; background-color: yellow\">Hello</span><br>\n" +
                "\t<button onclick=\"alert('Hello!!!');\">Click Me!</button><br>\n" +
                "</body>\n" +
                "</html>";
        FileIODemo.writeToFile("E:\\demo.html", content, false);
        FileIODemo.readFromFile("E:\\demo.html");
    }
}
