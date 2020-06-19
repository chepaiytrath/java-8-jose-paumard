package introtolambdas;

import java.io.File;
import java.io.FileFilter;

public class AFirstLamda {
    public static void main(String[] args) {
        /*FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };*/

        FileFilter filterLambda = (File pathname) -> pathname.getName().endsWith(".java");

        File dir = new File("D:\\Workspace\\Naukri_Prep_2020\\spring-security-jwt\\src\\main\\java\\io\\javabrains\\springsecurityjwt");
        File[] files = dir.listFiles(filterLambda);
        for(File f : files){
            System.out.println(f);
        }
    }
}
