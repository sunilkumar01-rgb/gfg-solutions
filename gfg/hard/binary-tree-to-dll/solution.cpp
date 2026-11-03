class Solution {
  public:
    Node* prev = nullptr;
    Node* head = nullptr;

    void inorder(Node* root) {
        if (root == nullptr) return;

        inorder(root->left);

        if (prev == nullptr) {
            head = root;
        } else {
            prev->right = root;
            root->left = prev;
        }

        prev = root;

        inorder(root->right);
    }

    Node* treeToDLL(Node* root) {
        prev = nullptr;
        head = nullptr;

        inorder(root);

        if (head != nullptr)
            head->left = nullptr;

        if (prev != nullptr)
            prev->right = nullptr;

        return head;
    }
};