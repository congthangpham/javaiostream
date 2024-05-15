package bai1;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Nhập đường dẫn tập tin từ người dùng
        String filePath = ""; // Đường dẫn tập tin sẽ được lưu ở đây
        try {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            System.out.print("Nhập đường dẫn tập tin: ");
            filePath = scanner.nextLine();
            scanner.close();
        } catch (Exception e) {
            System.out.println("Lỗi khi nhập đường dẫn tập tin: " + e.getMessage());
            return;
        }

        // Tạo một đối tượng File từ đường dẫn đã nhập
        File file = new File(filePath);

        // Kiểm tra xem tập tin có tồn tại không
        if (!file.exists()) {
            System.out.println("Tập tin không tồn tại.");
            return;
        }

        // Lấy độ dài của tập tin (tính bằng byte)
        long fileSize = file.length();

        // In ra độ dài của tập tin (đã chuyển sang đơn vị KB và MB)
        System.out.println("Độ lớn của tập tin là: " + formatFileSize(fileSize));
    }

    // Phương thức để chuyển đổi kích thước tập tin từ byte sang KB hoặc MB
    public static String formatFileSize(long size) {
        final long KILOBYTE = 1024;
        final long MEGABYTE = KILOBYTE * KILOBYTE;

        if (size < KILOBYTE) {
            return size + " bytes";
        } else if (size < MEGABYTE) {
            return String.format("%.2f KB", (double) size / KILOBYTE);
        } else {
            return String.format("%.2f MB", (double) size / MEGABYTE);
        }
    }
}

