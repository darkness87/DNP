/**
 * https://cli.vuejs.org/config 에서 설정값 체크할것
*/

module.exports = {
	// publicPath: process.env.NODE_ENV === 'production' ? '/production-sub-path/' : '/dnp',
	publicPath: "/dnp",
	outputDir : "../src/main/webapp",		// package.json의 설정된 경로값이 우선적으로 적용 default : "dist"
	assetsDir : "",								// css, js 등의 파일의 폴더 경로를 제어함 default : ""
	indexPath : "index.html",					// 메인페이지의 위치와 파일명을 지정가능 기본경로는 outputDir에 의존한다. default : "index.html"
	
	"transpileDependencies": [
		"vuetify"
	],
	pluginOptions: {
		electronBuilder: {
			builderOptions: {
				appId: 'dnp',
				asar: false,
				productName: 'DNP',
				win: {
					target: [
						{
							target: 'portable',
							arch: ['x64'],
						}
					]
				}
			}
		}
	}
}