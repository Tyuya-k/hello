import java.util.Scanner;
import java.lang.Math;

public class NumberGuessingGame {

    public static void main(String[] args) {

        // ルールで指定された数（2桁の正の整数）をプログラム内で設定
        int secretNumber = 42;
        int maxAttempts = 5;

        System.out.println("--- 数当てゲーム ---");
        System.out.println("隠された2桁の正の整数を当ててください。");
        System.out.println("チャンスは" + maxAttempts + "回です。");
        System.out.println("--------------------");

        // ユーザからの入力を受け取る準備
        Scanner scanner = new Scanner(System.in);

        // 5回までループを繰り返す
        for (int i = 1; i <= maxAttempts; i++) {
            System.out.print(i + "回目の予想: ");
            int userGuess;

            // 数字以外の入力に対応するための例外処理
            try {
                userGuess = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("エラー: 数字を入力してください。");
                scanner.next(); // 不正な入力をストリームからクリア
                i--; // 無効な入力は試行回数にカウントしない
                continue;
            }

            // 入力された数が2桁の正の整数であるかチェック
            if (userGuess < 10 || userGuess > 99) {
                System.out.println("エラー: 2桁の正の整数（10～99）を入力してください。");
                i--; // 無効な入力は試行回数にカウントしない
                continue;
            }

            // --- 正解・不正解の判定 ---

            // 1. 当たった場合
            if (userGuess == secretNumber) {
                System.out.println("当たり！正解です！");
                break; // ループを抜けてゲーム終了
            }

            // 2. 外れた場合
            // 差を計算（絶対値）
            int difference = Math.abs(secretNumber - userGuess);

            if (userGuess < secretNumber) {
                System.out.print("もっと大きいです。");
            } else {
                System.out.print("もっと小さいです。");
            }

            // 20以上差があるか判定
            if (difference >= 20) {
                System.out.println(" (ヒント: 20以上離れています)");
            } else {
                System.out.println(); // 改行のため
            }

            // 最終回で外れた場合のメッセージ
            if (i == maxAttempts) {
                System.out.println("残念！ゲームオーバーです。");
                System.out.println("正解は " + secretNumber + " でした。");
            }
        }
        
        // スキャナーを閉じる
        scanner.close();
    }
}