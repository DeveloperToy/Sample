/*
 * マスタテーブルのテーブル生成クエリ.
 */
 # APIキーマスタ
CREATE TABLE IF NOT EXISTS DEVELOPER_TOY.M_API_KEY(API_KEY char(8) PRIMARY KEY, EXPIRATION_DATE DATE);

/*
 * トランザクションテーブルの生成クエリ.
 */
 