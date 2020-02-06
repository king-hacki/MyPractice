/*

    1) Create Tree for our datas;
    2) Write Datas to Tree's nodes;
    3) Work with our datas;
    4) Create output data
 
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>


char *reverse_inside_parentheses (char *text) {
    
    struct node {
        
        int             end;
        int             node_end;
        int             nodes_check;
        int             is_used;
        int             do_reverse;
        struct node     *parent;
        struct node     **children;
        char            *text;
        
    };
    
    typedef struct node *node;
 
//  1

    node root = NULL;
    int count_node = 0;
    for (int i = 0; text[i] != '\0'; i++)
        if (text[i] == '(')
            count_node++;
    root = (node) calloc(1, sizeof(struct node));
    root->end = 0;
    root->nodes_check = 1;
    root->node_end = 0;
    root->is_used = 0;
    root->do_reverse = 0;
    root->parent = NULL;
    root->children = (node *) calloc(count_node, sizeof(struct node));
    root->text = calloc(strlen(text), sizeof(char));
    node current = root;
    for (int i = 0; text[i] != '\0'; i++) {
        if (text[i] == '(') {
            int j = 0;
            while (1) {
                if (current->children[j] == NULL) {
                    current->children[j] = (node) calloc(1, sizeof(struct node));
                    current->children[j]->end = 0;
                    current->children[j]->nodes_check = 1;
                    current->children[j]->node_end = 0;
                    current->children[j]->is_used = 0;
                    current->children[j]->parent = current;
                    current->children[j]->children = (node *) calloc(count_node, sizeof(struct node));
                    current->children[j]->text = calloc(strlen(text), sizeof(char));
                    if (current->children[j]->parent->do_reverse)
                        current->children[j]->do_reverse = 0;
                    else
                        current->children[j]->do_reverse = 1;
                    current = current->children[j];
                    break;
                } else j++;
            }
        }
        
        if (text[i] == ')') {
            current = current->parent;
        }
    }
// 2
    current = root;
    for (int i = 0; text[i] != '\0'; i++) {
        if (text[i] == '(' || text[i] == ')') {
            if (text[i] == '(') {
                int j = 0;
                while (current->text[j] != '\0') j++;
                current->text[j] = '(';
                j = 0;
                while (current->children[j]->is_used) j++;
                current->children[j]->is_used = 1;
                current = current->children[j];
            } else {
                current = current->parent;
                int j = 0;
                while (current->text[j] != '\0') j++;
                current->text[j] = ')';
            }
        } else {
            int j = 0;
            while (current->text[j] != '\0') j++;
            current->text[j] = text[i];
        }
    }
    
// 3
    current = root;
    while (1) {
        if (current->nodes_check) {
            int count = 0;
            while (current->children[count] != NULL)
                count++;
            current->nodes_check = count;
        }
        if (current->node_end < current->nodes_check) {
            current = current->children[current->node_end];
            current->parent->node_end += 1;
        } else
            if (current->parent != NULL)
                current = current->parent;
            else
                break;
        if (current->do_reverse && current->is_used) {
            char *work_text = (char *) calloc(strlen(text), sizeof(char));
            int j = 0;
            while (current->text[j] != '\0') j++;
            int i = 0;
            while (j-- >= 0)
                if (current->text[j] == '(' || current->text[j] == ')')
                    if (current->text[j] == '(')
                        work_text[i++] = ')';
                    else
                        work_text[i++] = '(';
                else
                    work_text[i++] = current->text[j];
            
            strcpy(current->text, work_text);
            free(work_text);
        }
        current->is_used = 0;
    }

    
// 4
    
    char *work_text = (char *) calloc(strlen(text), sizeof(char));
    char *begin_of_work_text = work_text;
    
    current = root;
    
    while (1) {
        if (current->text[current->end] == '(' || current->text[current->end] == '\0') {
            if (current->text[current->end] == '(') {
                *work_text++ = current->text[current->end];
                current->end++;
                int j = 0;
                while (current->children[j]->is_used) j++;
                current = current->children[j];
                current->is_used = 1;
            } else {
                if (current->parent == NULL)
                    break;
                else {
                    current = current->parent;
                    current->is_used = 1;
                }
            }
        } else {
            *work_text++ = current->text[current->end];
            current->end++;
        }
    }
    
    return begin_of_work_text;
}

int main () {
    
    //printf("[ + ] text : %s\n", reverse_inside_parentheses("h(el)lo"));
    //printf("[ + ] text : %s\n", reverse_inside_parentheses("a ((d e) c b)"));
    //printf("[ + ] text : %s\n", reverse_inside_parentheses("one (two (three) four)"));
    //printf("[ + ] text : %s\n", reverse_inside_parentheses("one (ruof ((rht)ee) owt)"));
    printf("[ + ] (so(me)) (text (to) (te(st)(brt))) in (this) pro(gra)m\n");
    printf("[ + ] text : %s\n", reverse_inside_parentheses("(so(me)) (text (to) (te(st)(brt))) in (this) pro(gra)m"));
    //printf("[ + ] text : %s\n", reverse_inside_parentheses("some (text to (test)) (in more (test in (this (pl(a)c(e))))) this pro(gra)m"));
    
}
