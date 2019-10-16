package com.wfteamlab.engineering.common.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

/**
 * ファイル関連Util
 * アップロードしたファイルの保存、削除
 */
public class FileService {

	/**
	 * アップロードされたファイルを保存して、そのファイル名をリターン
	 * @param mfile アップロードファイル
	 * @param path 保存する経路
	 * @return 保存されたファイル名
	 */
	public static String saveFile(MultipartFile mfile, String uploadPath) {
		//アップロードしたファイルをチェック
		if (mfile == null || mfile.isEmpty() || mfile.getSize() == 0) {
			return null;
		}
		
		//保存先フォルダがない場合、生成
		File path = new File(uploadPath);
		if (!path.isDirectory()) { //그 경로에 파일이 존재 하는지 하지 않는지를 boolean으로 return함.
			path.mkdirs();
		}
		
		//元本ファイル名
		String originalFilename = mfile.getOriginalFilename();
		
		//保存するファイル名設定
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String savedFilename = sdf.format(new Date());
		
		//元本ファイルの拡張子
		String ext;
		int lastIndex = originalFilename.lastIndexOf('.');
		//拡張子が無い場合
		if (lastIndex == -1) {
			ext = "";
		}
		//拡張子がある場合
		else {
			ext = "." + originalFilename.substring(lastIndex + 1);
		}

		//File オブジェクト
		File serverFile = null;
		
		//同じファイル名がある場合の処理
		while (true) {
			serverFile = new File(uploadPath + "/" + savedFilename + ext);
			if ( !serverFile.isFile()) break;	
			savedFilename = savedFilename + new Date().getTime();	
		}		
		
		//ファイル保存
		try {
			mfile.transferTo(serverFile); 
		} catch (Exception e) {
			savedFilename = null;
			e.printStackTrace();
		}
		
		return savedFilename + ext;
	}
	
	/**
	 * ファイルの削除
	 * @param fullpath 削除するファイルの経路
	 * @return 削除成功有無
	 */
	public static boolean deleteFile(String fullpath) {
		//削除成功有無の変数
		boolean result = false;
		
		//File オブジェクト生成
		File delFile = new File(fullpath);
		
		//該当ファイルが存在すると、削除
		if (delFile.isFile()) {
			delFile.delete();
			result = true;
		}
		
		return result;
	}
}
