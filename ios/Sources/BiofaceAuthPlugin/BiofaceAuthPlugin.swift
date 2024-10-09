import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(BiofaceAuthPlugin)
public class BiofaceAuthPlugin: CAPPlugin, CAPBridgedPlugin {
    public let identifier = "BiofaceAuthPlugin"
    public let jsName = "BiofaceAuth"
    public let pluginMethods: [CAPPluginMethod] = [
        CAPPluginMethod(name: "echo", returnType: CAPPluginReturnPromise),
        CAPPluginMethod(name: "authenticate", returnType: CAPPluginReturnPromise)
    ]
    private let implementation = BiofaceAuth()

    @objc func echo(_ call: CAPPluginCall) {
        let value = call.getString("value") ?? ""
        call.resolve([
            "value": implementation.echo(value)
        ])
    }

    @objc func authenticate(_ call: CAPPluginCall) {
        implementation.authenticate { success, error in
            if success {
                call.resolve([
                    "authenticated": true
                ])
            } else {
                call.reject(error ?? "Authentication failed")
            }
        }
    }
}
