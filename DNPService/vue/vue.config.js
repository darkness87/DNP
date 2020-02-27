/**
 * https://cli.vuejs.org/config 에서 설정값 체크할것
*/

module.exports = {
	// publicPath: process.env.NODE_ENV === 'production' ? '/production-sub-path/' : '/dnp',
	publicPath: "/dnp/vue",
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