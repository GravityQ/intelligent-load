package com.usst.load.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.*;


/**
 * 文件上传
 *
 * @author junlin.qi on 2018/7/19
 */
@Controller
public class FileController {
	/**
	 * Resource十一个工具类，代表了资源的抽象
	 * 创建pictures文件目录
	 */
	public static final Resource PICTURE_DIR = new FileSystemResource("./pictures");

	@RequestMapping("upload")
	public String upload() {
		return "uploadPage";
	}

	/**
	 * 图片上传
	 *
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/uploadPicture", method = RequestMethod.POST)
	public String uploadPicture(MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
		if (file.isEmpty() || !isImage(file)) {
			redirectAttributes.addFlashAttribute("error", "文件错误！");
			return "uploadPage";
		}
		String filename = file.getOriginalFilename();
		File tempFile = File.createTempFile("pic", getFileExtension(filename), PICTURE_DIR.getFile());
		try (InputStream inputStream = file.getInputStream();
			 OutputStream outputStream = new FileOutputStream(tempFile)) {
			IOUtils.copy(inputStream, outputStream);
		}
		return "uploadPage";
	}

	/**
	 * 获取文件扩展名
	 *
	 * @param name
	 * @return
	 */
	private static String getFileExtension(String name) {
		return name.substring(name.lastIndexOf("."));
	}

	/**
	 * 判断是否是图片文件
	 *
	 * @param file
	 * @return
	 */
	private boolean isImage(MultipartFile file) {
		return file.getContentType().startsWith("image");
	}
}
