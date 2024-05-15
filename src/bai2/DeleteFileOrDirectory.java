package bai2;
import java.io.File;
import java.util.Scanner;

public class DeleteFileOrDirectory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập đường dẫn tệp hoặc thư mục cần xóa: ");
        String path = scanner.nextLine();

        File fileOrDir = new File(path);

        if (!fileOrDir.exists()) {
            System.out.println("Tệp hoặc thư mục không tồn tại.");
            return;
        }

        System.out.println("Bạn có chắc chắn muốn xóa " + path + "? (yes/no): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("yes")) {
            boolean result = deleteRecursively(fileOrDir);
            if (result) {
                System.out.println("Đã xóa thành công " + path);
            } else {
                System.out.println("Xóa không thành công.");
            }
        } else {
            System.out.println("Hủy thao tác xóa.");
        }
    }

    public static boolean deleteRecursively(File fileOrDir) {
        if (fileOrDir.isDirectory()) {
            File[] contents = fileOrDir.listFiles();
            if (contents != null) {
                for (File file : contents) {
                    if (!deleteRecursively(file)) {
                        return false;
                    }
                }
            }
        }
        return fileOrDir.delete();
    }
}
