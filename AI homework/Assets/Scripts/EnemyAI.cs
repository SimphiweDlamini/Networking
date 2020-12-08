using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class EnemyAI : MonoBehaviour
{
    enum State { 
    Patrol,
    Chasing,
    Return,
    }
    public GameObject target;
    public float speed = 2f;
    public float pspeed = 1f;
    private State state = State.Patrol;
    private bool chase;
    private float distance;
    private Vector3 beginning;
    private float plength = 5f;
    private float pdistance;
    
    void Start()
    {
        beginning = transform.position;
    }

    // Update is called once per frame
    void Update()
    {
        distance = Vector3.Distance(transform.position, target.transform.position);
        switch (state)
        {
            case State.Patrol:
                pdistance = beginning.x - plength;
                Vector3 patroldirection = new Vector3(pdistance, beginning.y ,0);
                transform.position = Vector3.MoveTowards(transform.position,patroldirection , pspeed * Time.deltaTime);
                if (distance < 3)
                {
                    state = State.Chasing;
                }
                if (transform.position == patroldirection) {
                    plength *= -1;
                }
                break;
            case State.Return:
                transform.position = Vector3.MoveTowards(transform.position, beginning, pspeed * Time.deltaTime);
                if (distance < 3)
                {
                    state = State.Chasing;
                }
                if (transform.position == beginning) {
                    state = State.Patrol;
                }
                break;
            case State.Chasing:
                    transform.position = Vector3.MoveTowards(transform.position, target.transform.position, speed * Time.deltaTime);
                if (distance > 3)
                {
                    state = State.Return;
                }
                if (distance < 1) {
                    SceneManager.LoadScene(SceneManager.GetActiveScene().name);
                }
                break;
        }
       

    }

}
