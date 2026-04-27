# Bài 03: Tự động hóa CI/CD với GitHub Actions

## 1. Cấu hình Workflow
Dự án đã sử dụng GitHub Actions (`.github/workflows/maven-ci.yml`) với các cấu hình:
- **Trigger:** Tự động chạy khi có sự kiện `push` hoặc `pull_request` vào nhánh `main`.
- **Vòng đời Maven:** Thực thi lệnh `mvn clean package` để chạy cả Unit Test (Surefire) và đóng gói ra file `.jar`.
- **Lưu trữ Artifact:** Sử dụng action `upload-artifact@v4` để giữ lại file `.jar` trong kho lưu trữ của GitHub Action sau khi build thành công.

## 2. Kiểm thử tự động hóa & Phân tích Log lỗi
Để chứng minh CI hoạt động, em đã cố tình gây lỗi logic trong file `MathUtilsTest.java` (Sửa kỳ vọng $2 + 3 = 6$).

**Quá trình bắt lỗi từ GitHub Actions Log:**
Khi hệ thống chạy đến step `Chạy Maven Build (Test & Package)`, workflow đã lập tức dừng lại với mã lỗi `Process completed with exit code 1`. 

Kiểm tra execution logs, em phát hiện dòng log sau được Maven Surefire in ra:
```text
[ERROR] Failures: 
[ERROR]   MathUtilsTest.testAdd:13 2 + 3 phải bằng 5 ==> expected: <6> but was: <5>
[INFO] 
[ERROR] Tests run: 1, Failures: 1, Errors: 0, Skipped: 0

Kết luận Debug: Log chỉ ra rõ ràng Unit Test testAdd ở dòng 13 bị tạch do kỳ vọng sai. Sau khi đọc log này, em đã tiến hành fix code, commit lại và workflow đã pass thành công (hiển thị màu xanh) và sinh ra artifact project-executable-jar.zip đúng như kịch bản.