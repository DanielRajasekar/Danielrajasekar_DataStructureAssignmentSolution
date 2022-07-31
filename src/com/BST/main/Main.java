package com.BST.main;
import java.util.Arrays;
public class Main {
	
		public static void inorder(Node root)
		{
			if (root == null) {
				return;
			}

			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}

		public static Node convert(int[] keys, int low, int high, Node root)
		{
		
			if (low > high) {
				return root;
			}

		
			int mid = (low + high) / 2;

			
			root = new Node(keys[mid]);

		
			root.left = convert(keys, low, mid - 1, root.left);

		
			root.right = convert(keys, mid + 1, high, root.right);

			return root;
		}

		
		public static Node convert(int[] keys)
		{
		
			Arrays.sort(keys);

			
			return convert(keys, 0, keys.length - 1, null);
		}

		public static void main(String[] args)
		{
			// input keys
			int[] keys = { 50,30,60,10,55 };

			// construct a balanced binary search tree
			Node root = convert(keys);

			
			inorder(root);
		}
	}