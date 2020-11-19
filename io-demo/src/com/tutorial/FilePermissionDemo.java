package com.tutorial;

import java.io.FilePermission;
import java.security.PermissionCollection;

public class FilePermissionDemo {
    public static void addPermission(String filePath, String[] permissionsArray) {
        // cấp quyền
        String permissionString = String.join(",", permissionsArray);
        FilePermission filePermission = new FilePermission(filePath, permissionString);
        PermissionCollection permissions = filePermission.newPermissionCollection();
        permissions.add(filePermission);

        // kiểm tra và in ra quyền
        if (permissions.implies(new FilePermission(filePath, "read"))) {
            System.out.println("Quyền Read được cấp cho path " + filePath);
        }
        if (permissions.implies(new FilePermission(filePath, "read,write"))) {
            System.out.println("Quyền Read, Write được cấp cho path " + filePath);
        }
//        File file = new File(filePath);
//        file.setWritable(false);
//        file.setReadable(false, false);
//        System.out.println(file.canWrite());
//        System.out.println(file.canRead());
    }
}
