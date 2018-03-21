package developer.toy.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * サンプルアプリケーションの起動クラス.
 * @author rtaba
 */
@SpringBootApplication
public class SampleRunner {

	/**
	 * サンプルアプリケーションの起動メソッド.
	 * @param args コマンド引数
	 */
	public static void main(String[] args) {
		SpringApplication.run(SampleRunner.class, args);
	}
}
