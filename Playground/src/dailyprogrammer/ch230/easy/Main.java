package dailyprogrammer.ch230.easy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonString;
import javax.json.JsonValue;
import javax.json.JsonValue.ValueType;

;

public class Main {

	public static String TARGET = "dailyprogrammer";

	public static void main(String[] args) throws FileNotFoundException {
		System.out.print("Input1:     ");
		run("input1.txt");
		System.out.print("Input2:     ");
		run("input2.txt");
		System.out.print("Challenge1: ");
		run("challenge1.txt");
		System.out.print("Challenge2: ");
		run("challenge2.txt");
	}

	private static void run(String file) throws FileNotFoundException {
		JsonReader reader = Json.createReader(new FileReader(new File(file)));
		JsonObject jo = reader.readObject();
		System.out.println(findPath(jo));
	}

	private static String findPath(JsonObject jo) {
		Deque<String> stack = new ArrayDeque<String>();
		if (findPath(jo, stack)) {
			return stack.stream().collect(Collectors.joining(" -> "));
		}

		return "not found";
	}

	private static boolean findPath(JsonValue value, Deque<String> stack) {

		if (isTarget(value)) {
			return true;
		}

		if (isList(value)) {
			int i = 0;
			for (JsonValue jv : (JsonArray) value) {
				stack.addLast(String.valueOf(i++));
				if (findPath(jv, stack)) {
					return true;
				}
			}
		}

		if (isObject(value)) {
			for (String key : ((JsonObject) value).keySet()) {
				stack.addLast(key);
				if (findPath(((JsonObject) value).get(key), stack)) {
					return true;
				}
			}
		}

		stack.pollLast();
		return false;
	}

	private static boolean isString(JsonValue jo) {
		return jo.getValueType() == ValueType.STRING;
	}

	private static boolean isList(JsonValue jo) {
		return jo.getValueType() == ValueType.ARRAY;
	}

	private static boolean isObject(JsonValue jo) {
		return jo.getValueType() == ValueType.OBJECT;
	}

	private static boolean isTarget(JsonValue jo) {
		return isString(jo) && ((JsonString) jo).getString().equals(TARGET);
	}

}
