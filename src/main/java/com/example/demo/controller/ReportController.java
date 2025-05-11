package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.IEmployeeService;
import com.example.demo.utils.ReportUtil;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/report")
public class ReportController {

  private final IEmployeeService iEmployeeService;

  @GetMapping("/employee")
  public ResponseEntity<byte[]> generateEmployeeReport() throws IOException {
    try {
      // Lấy danh sách nhân viên
      List<EmployeeDto> employees = iEmployeeService.getAllEmployees();

      // Kiểm tra dữ liệu có rỗng không
      if (employees == null || employees.isEmpty()) {
        throw new RuntimeException("Danh sách nhân viên rỗng.");
      }

      // Đường dẫn đến file Jasper đã biên dịch
      String jasperPath = new File("src/main/resources/FristAReport.jasper").getAbsolutePath();

      // Tạo data source cho Jasper
      JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);

      // Các tham số cho report (nếu cần)
      HashMap<String, Object> parameters = new HashMap<>();
      parameters.put("TABLE_DATA_SOURCE", dataSource);

      // Tạo báo cáo dạng PDF
      byte[] pdfData = ReportUtil.generateReport(employees, jasperPath, parameters);

      // Trả về PDF
      return ResponseEntity.ok()
          .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=employee_report.pdf")
          .header(HttpHeaders.CONTENT_TYPE, "application/pdf")
          .body(pdfData);

    } catch (JRException e) {
      throw new RuntimeException("Lỗi khi tạo báo cáo", e);
    }
  }
}
